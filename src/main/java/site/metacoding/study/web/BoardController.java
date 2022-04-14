package site.metacoding.study.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.study.domain.Board;
import site.metacoding.study.domain.BoardRepository;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardRepository boardRepository;

    @GetMapping({ "/", "/board" })
    public String boardList() {
        return "boardList";
    }

    @GetMapping("/board/{id}")
    public String boardList(@PathVariable Integer id) {
        return "boardDetail";
    }

    @GetMapping("/board/writeForm")
    public String boardWriteForm() {
        return "boardWriteForm";
    }

    @GetMapping("/board/updateForm")
    public String boardUpdateForm() {
        return "boardUpdateForm";
    }

    @PostMapping("/board")
    public String boardWrite(Board board) { // title, content, nickname 받기
        boardRepository.save(board);
        return "redirect:/";
    }
}