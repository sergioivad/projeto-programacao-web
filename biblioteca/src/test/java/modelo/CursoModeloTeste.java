package modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import entidade.Curso;
import entidade.Jornal;
import entidade.TipoCurso;
import entidade.TipoItem;
import excecao.CursoModeloException;
import excecao.ItemModeloException;


public class CursoModeloTeste {
	
	private CursoModelo cursoModelo;
	
	public CursoModeloTeste(){
		this.cursoModelo = new CursoModelo();
	}
	
	@Test(expected = CursoModeloException.class)
	public void testInserirCursoVazio() throws CursoModeloException {
		cursoModelo.inserirCurso(null);
	}
	
	@Test
	public void testInserirCursoIncompletoDeAtributos() {
		Curso curso = new Curso();
		//Enviar sem Nome
		try {
			cursoModelo.inserirCurso(curso);
		} catch (CursoModeloException e) {
			assertTrue(true);
		}
		//Enviar sem �rea
		curso.setArea("Exatas");
		try {
		cursoModelo.inserirCurso(curso);
		} catch (CursoModeloException e) {
			assertTrue(true);
		}	
	}
	
	@Test (expected = CursoModeloException.class)
	public void testInserirCursoDuplicado() throws CursoModeloException{
		Curso curso  = new Curso();

		curso.setNome("Medicina");
		curso.setArea("Sa�de");
		
		TipoCurso tipoCurso  = new TipoCurso();
		tipoCurso.setCod(0);
		tipoCurso.setNome("Graduacao");
		
		curso.setTipoCurso(tipoCurso);
		
		cursoModelo.inserirCurso(curso);
		cursoModelo.inserirCurso(curso);
		
	}
	
	
	
	@Test 
	public void testInserirRecuperarCurso() throws CursoModeloException{
		Curso curso  = new Curso();

		curso.setNome("Ci�ncia da Computa��o");
		curso.setArea("Exatas");
		
		TipoCurso tipoCurso  = new TipoCurso();
		tipoCurso.setCod(0);
		tipoCurso.setNome("Graduacao");
		
		curso.setTipoCurso(tipoCurso);
		
		try {
			cursoModelo.inserirCurso(curso);
		} catch (CursoModeloException e) {
			assertFalse(e == null);
		}

		Curso cursoRecuperado;
		try {
			cursoRecuperado = (Curso) cursoModelo.recuperarCursoPorNome(curso.getNome());
			assertEquals(curso, cursoRecuperado);
		} catch (CursoModeloException e) {
			assertFalse(e != null);
		}
	}
	

	@Test
	public void testRemoverCurso() {
		
		Curso curso = new Curso();
		curso.setArea("Area_Excluir");
		curso.setNome("Curso_Excluir");
		
		curso.setTipoCurso(new TipoCurso());
		
		try {
			cursoModelo.inserirCurso(curso);
		} catch (CursoModeloException e) {
			assertFalse(e != null);
		}

		try {
			cursoModelo.removerCursoPorNome(curso.getNome());
		} catch (CursoModeloException e) {
			assertFalse(e != null);
		}
		
		Curso c1 = null;
		Curso c2 = new Curso();
		
		try {
			c2 = (Curso) cursoModelo.recuperarCursoPorNome(curso.getNome());
		}catch(CursoModeloException e){
			assertFalse(e != null);
		}
		
		assertEquals(c1 , c2);
	}
		
		
	@Test
	public void testAtualizarCurso() {
		Curso c4 = new Curso();
		c4.setNome("Matem�tica");
		c4.setArea("Exatas");
		
		c4.setTipoCurso(new TipoCurso());
		
		try {
			cursoModelo.inserirCurso(c4);
		}catch(CursoModeloException e){
			assertFalse(e != null);
		}
		
		Curso c5 = null;
		try {
			c5 = (Curso) cursoModelo.recuperarCursoPorNome("Matem�tica");
		}catch(CursoModeloException e){
			assertFalse(e != null);
		}
		
		String atualizarNome = "Estat�stica";
		
		assertEquals(c4.getNome(), c5.getNome());
		
		c5.setNome(atualizarNome);
		
		
		try {
			cursoModelo.atualizarCurso(c4);
		}catch(CursoModeloException e){
			assertFalse(e != null);
		}
		try {
			c5 = (Curso) cursoModelo.recuperarCursoPorNome("Matem�tica");
		} catch (CursoModeloException e) {
			assertFalse(e != null);
		}
		
		assertEquals(atualizarNome, c5.getNome());
	}
}


