package com.cafe24.m2o_by;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cafe24.m2o_by.domain.Member;
import com.cafe24.m2o_by.domain.Team;

public class App {
	public static void main(String[] args) {
		// 1. Entity Manager Factory 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("m2o-by"); // db

		// 2. Entity Manager 생성
		EntityManager em = emf.createEntityManager();

		// 3.Get TX
		EntityTransaction tx = em.getTransaction();

		// 4. TX Begins
		tx.begin();

		// 5. Business Logic
		try {
			Member member1 = new Member();
			member1.setName("회원1");
			em.persist(member1);

			Team team = new Team();
			team.setName("A");

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

		// 6. TX Commit
		tx.commit();

		// 7. Entity Manager 종료
		em.clear();

		// 8. Entity Manager Factory 종료
		emf.close();
	}

}
