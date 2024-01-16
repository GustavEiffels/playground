package practice.jpa.board.repository.member;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import practice.jpa.board.dto.FindMemberDto;
import java.util.List;
import static org.springframework.util.StringUtils.*;
import static practice.jpa.board.entity.QMember.member;

public class MemberRepositoryImpl implements MemberRepositoryCustom
{
    private final JPAQueryFactory queryFactory;

    public MemberRepositoryImpl(EntityManager em)
    {
        queryFactory = new JPAQueryFactory(em);
    }


    @Override
    public Page<FindMemberDto> getConditionMemberList(FindMemberDto findMemberDto, Pageable pageable) {
        List<FindMemberDto> findMemberDtoList =
                queryFactory.select(
                        Projections.fields(
                                FindMemberDto.class,
                                member.userName,
                                member.age,
                                member.userEmail,
                                member.userNick,
                                member.phone,
                                member.address.city,
                                member.address.street,
                                member.address.zipcode))
                        .from(member)
                        .where(
                                userNameEq(findMemberDto.getUserName()),
                                userEmailEq(findMemberDto.getUserEmail()),
                                userNickEq(findMemberDto.getUserNick()),
                                phoneEq(findMemberDto.getPhone()),
                                cityEq(findMemberDto.getCity()),
                                streetEq(findMemberDto.getStreet()),
                                zipcodeEq(findMemberDto.getZipcode())
//                                ,
//                                ageLoe(findMemberDto.getAgeLoe()),
//                                ageGoe(findMemberDto.getAgeGoe())
                        )
                        .offset(pageable.getOffset())
                        .limit(pageable.getPageSize())
                        .fetch();
        return new PageImpl<>(findMemberDtoList,pageable,findMemberDtoList.size());
    }



    private BooleanExpression userNameEq(String userName){
        return hasText(userName) ? member.userName.eq(userName) : null;
    }


    private BooleanExpression userEmailEq(String userEmail){
        return hasText(userEmail) ? member.userEmail.eq(userEmail) : null;
    }

    private BooleanExpression userNickEq(String userNick){
        return hasText(userNick) ? member.userNick.eq(userNick) : null;
    }

    private BooleanExpression phoneEq(String phone){
        return hasText(phone) ? member.phone.eq(phone) : null;
    }

    private BooleanExpression cityEq(String city){
        return hasText(city) ? member.address.city.eq(city) : null;
    }

    private BooleanExpression streetEq(String street){
        return hasText(street) ? member.address.street.eq(street) : null;
    }

    private BooleanExpression zipcodeEq(String zipcode){
        return hasText(zipcode) ? member.address.zipcode.eq(zipcode) : null;
    }

    private BooleanExpression ageLoe(Integer ageLoe) {
        return ageLoe != null ? member.age.loe(ageLoe):null;
    }

    private BooleanExpression ageGoe(Integer ageGoe) {
        return ageGoe != null ? member.age.goe(ageGoe):null;
    }

}
