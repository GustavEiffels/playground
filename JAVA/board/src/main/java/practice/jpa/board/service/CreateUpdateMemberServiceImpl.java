package practice.jpa.board.service;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.jpa.board.common.config.security.TokenSetting;
import practice.jpa.board.dto.MemberInfoDto;
import practice.jpa.board.entity.*;
import practice.jpa.board.entity.embedded.Address;
import practice.jpa.board.enumtype.RoleType;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = false)
public class CreateUpdateMemberServiceImpl implements CreateUpdateMemberService {
    private final EntityManager em;
    private final BCryptPasswordEncoder passwordEncoder;

    @Transactional
    public Long createMember(MemberInfoDto memberInfoDto)
    {
        Member member = Member.builder()
                .age(memberInfoDto.getAge())
                .userName(memberInfoDto.getUserName())
                .phone(memberInfoDto.getPhone())
                .userEmail(memberInfoDto.getUserEmail())
                .userNick(memberInfoDto.getUserNick())
                .address(new Address(memberInfoDto.getCity(), memberInfoDto.getStreet(), memberInfoDto.getZipcode()))
                .build();
        em.persist(member);

        Auth auth = Auth.builder()
                .loginId(memberInfoDto.getLoginId())
                .password(passwordEncoder.encode(memberInfoDto.getPassword()))
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
