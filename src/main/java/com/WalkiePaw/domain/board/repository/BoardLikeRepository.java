package com.WalkiePaw.domain.board.repository;

import com.WalkiePaw.domain.board.entity.BoardLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardLikeRepository extends JpaRepository<BoardLike, Long> {
    BoardLike findByMemberIdAndBoardId(Long memberId, Long boardId);

    @Query("select bl.board.id, count(bl) from BoardLike bl group by bl.board.id")
    List<Integer[]> countAllBoardLike();
}
