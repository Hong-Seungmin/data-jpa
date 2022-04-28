package study.datajpa.repository;

import org.springframework.data.jpa.domain.Specification;
import study.datajpa.entity.Member;
import study.datajpa.entity.Team;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;

public class MemberSpec {

    public static Specification<Member> teamName(final String teamName) {
        return (root, query, criteriaBuilder) -> {
            Join<Member, Team> t = root.join("team", JoinType.INNER);
            return criteriaBuilder.equal(t.get("name"), teamName);
        };
    }
}
