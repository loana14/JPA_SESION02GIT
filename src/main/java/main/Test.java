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
		
		//Query query = em.createNativeQuery("{call FINDALL_USU()}", TbUsuario.class);
		Query query = em.createNativeQuery("{call USP_VALIDACESSO(?,?)}", TbUsuario.class);
		query.setParameter(1, "U001@gmail.com");
		query.setParameter(2, "10001");
		
		TbUsuario usu = (TbUsuario)query.getSingleResult();
		if(usu==null){
			System.out.println("El usuario no existe");
		}else{
			System.out.println("Bienvenido " + usu.getNomUsua()+ " " + usu.getApeUsua());
		}
		
		
		//List<TbUsuario> lstUsuarios = query.getResultList();
		
		//List<TbUsuario> lstUsuarios = em.createQuery("Select a From TbUsuario a", TbUsuario.class).getResultList();
		System.out.println("==============================================");
		
		/*Mostrar cantidad de usuarios*/
		//System.out.println("nro de usuarios:" +lstUsuarios.size());
		System.out.println("==============================================");

	}

}
