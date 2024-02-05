package practice.jpa.board.repository.post;


import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import practice.jpa.board.controller.dto.PostDto;
import practice.jpa.board.controller.dto.SearchPostDto;
import practice.jpa.board.controller.dto.SearchPostResultDto;
import java.util.List;
import static org.springframework.util.StringUtils.hasText;
import static practice.jpa.board.entity.QAuth.auth;
import static practice.jpa.board.entity.QMember.member;
import static practice.jpa.board.entity.QPost.post;


public class PostRepositoryImpl implements PostRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    public PostRepositoryImpl(EntityManager em)
    {
        queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Page<SearchPostResultDto> getSearchPost(SearchPostDto request, Pageable pageable) {
        List<SearchPostResultDto> searchPostReq =

                queryFactory.select(
                        Projections.fields(
                                SearchPostResultDto.class,
                                member.userNick.as("authorNick"),
                                post.title.as("title"),
                                post.contents.as("contents"),
                                post.view.as("views"))
                        )
                        .from(post)
                        .join(post.auth , auth)
                        .join(auth.member, member)
                        .where(
                            authorNickEq(request.getAuthorNick()),
                                postTitleEq(request.getTitle()),
                                postContentsEq(request.getContents())
                        )
                        .orderBy(request.isAsc() ? post.view.asc() : post.view.desc())
                        .offset(pageable.getOffset())
                        .limit(pageable.getPageSize())
                        .fetch();

        System.out.println("ABLE");

        return new PageImpl<>(searchPostReq,pageable,searchPostReq.size());
    }

    private BooleanExpression postTitleEq(String title){
        return hasText(title) ? post.title.like("%" + title + "%") : null;
    }

    private BooleanExpression postContentsEq(String contents){
        return hasText(contents) ? post.contents.like("%" + contents + "%") : null;
    }

    private BooleanExpression authorNickEq(String authorNick){
        return hasText(authorNick) ? member.userNick.like("%" + authorNick + "%") : null;
    }
}
