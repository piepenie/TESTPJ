package com.example.board.service;

import com.example.board.dto.BoardDTO;
import com.example.board.repository.BoardRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // 해당 클래스를 서비스로 지정
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepo boardRepo;

    public void save(BoardDTO boardDTO) {
        boardRepo.save(boardDTO);
    }

    public List<BoardDTO> findAll() {
        return  boardRepo.findAll();
    }

    public void updateHits(Long id) {
        boardRepo.updateHits(id);
    }

    public BoardDTO findById(Long id) {
        return boardRepo.findById(id);
    }

    public void update(BoardDTO boardDTO) {
        boardRepo.update(boardDTO);
    }

    public void delete(Long id) {
        boardRepo.delete(id);
    }
}
