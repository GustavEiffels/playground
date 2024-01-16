package practice.jpa.board.service;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.jpa.board.dto.JoinDto;
import practice.jpa.board.entity.Auth;
import practice.jpa.board.entity.Member;
import practice.jpa.board.entity.Role;
import practice.jpa.board.entity.RoleAndAuth;
import practice.jpa.board.entity.embedded.Address;
import practice.jpa.board.enumtype.RoleType;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = false)
public class CreateUpdateMemberService {

    private final EntityManager em;

    @Transactional
    public long createMember(JoinDto joinDto)
    {
        Member member = Member.builder()
                .age(joinDto.getAge())
                .userName(joinDto.getUserName())
                .phone(joinDto.getPhone())
                .userEmail(joinDto.getUserEmail())
                .userNick(joinDto.getUserNick())
                .address(new Address(joinDto.getCity(), joinDto.getStreet(), joinDto.getZipcode()))
                .build();
        em.persist(member);


        Auth auth = Auth.builder()
                .loginId(joinDto.getLoginId())
                .password(joinDto.getPassword())
                .build();
        auth.linkMember(member);

        em.persist(auth);


        Role role = Role.builder()
                .type(RoleType.USER)
                .build();
        em.persist(role);

        RoleAndAuth roleAndAuth = RoleAndAuth.builder()
                .role(role)
                .build();

        roleAndAuth.assignAuthRole(auth);
        em.persist(roleAndAuth);
        em.flush();

        return auth.getPid();

    }

}
