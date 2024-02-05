package practice.jpa.board.repository.post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import practice.jpa.board.controller.dto.SearchPostDto;
import practice.jpa.board.controller.dto.SearchPostResultDto;


public interface PostRepositoryCustom {

    Page<SearchPostResultDto> getSearchPost(SearchPostDto request, Pageable pageable);
}
