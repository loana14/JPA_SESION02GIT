package main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.TbUsuario;

public class Test {

	public static void main(String[] args) {
		System.out.println("===JPA CRUD====");
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("JPA_clase01");
		EntityManager em = fabrica.createEntityManager();
		
		Query query = em.createNativeQuery("{call FINDALL_USU()}", TbUsuario.class);
		
		List<TbUsuario> lstUsuarios = query.getResultList();
		
		//List<TbUsuario> lstUsuarios = em.createQuery("Select a From TbUsuario a", TbUsuario.class).getResultList();
		System.out.println("==============================================");
		
		/*Mostrar cantidad de usuarios*/
		System.out.println("nro de usuarios:" +lstUsuarios.size());
		System.out.println("==============================================");

	}

}
