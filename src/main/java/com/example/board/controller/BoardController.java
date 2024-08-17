package com.example.board.controller;

import com.example.board.dto.BoardDTO;
import com.example.board.service.BoardService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor // final 이 달린 필드만 가지고 생성자를 만들어주는 어노테이션
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/save") // 세이브 주소 요청이 왔을때,
    public String save(){ // 자바 save 메서드 이름
        return "save"; // save html 을 띄워주겠다.
    }

    @PostMapping("/save")
    public String save(BoardDTO boardDTO){ // modelAttribute 를 사용해도됨
        System.out.println("boardDTO = " + boardDTO);
        boardService.save(boardDTO);
        return "redirect:/list"; // list 를 다시 재요청하는 방식
    }

    @GetMapping("/list")
    public String findAll(Model model){ //Model 은 데이터를 화면으로 가져갈 수 있도록 전달해주는 객체
        List<BoardDTO> boardDTOList = boardService.findAll();
        model.addAttribute("boardList", boardDTOList);
        System.out.println("boardDTOList = " + boardDTOList);
        return "list";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id, Model model){
        // 조회수 처리
        boardService.updateHits(id);
        // 상세 내용 가져오기
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board", boardDTO);
        System.out.println("boardDTO = " + boardDTO);
        return "detail";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Model model){
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board", boardDTO);
        return "update";
    }

    @PostMapping("/update/{id}")
    public String update(BoardDTO boardDTO,Model model){
        boardService.update(boardDTO);
        BoardDTO dto = boardService.findById(boardDTO.getId());
        model.addAttribute("board", dto);
        return "detail";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        boardService.delete(id);
        return "redirect:/list";
    }

}
