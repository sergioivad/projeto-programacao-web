package com.ufab.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ufab.servico.ILocacaoServico;


@Controller
public class LocacaoControlador {
	
		@Autowired
		private ILocacaoServico locacaoServico;
		

		@RequestMapping(value = "/locacao/tabela", method = RequestMethod.GET)
		public ModelAndView getTabela(Model model) {
			ModelAndView modv = new ModelAndView();
			modv.setViewName("locacao/tabela.locacao");
			modv.addObject("locacoes", locacaoServico.listarTodas());
			return modv;
		}
		
		@RequestMapping(value = "/locacao", method = RequestMethod.GET)
		public ModelAndView indexLocacao(Model model) {
			ModelAndView modv = new ModelAndView();
			modv.setViewName("locacao/locacao");
			return modv;
		}
		
		@RequestMapping(value = "/locacao/form", method = RequestMethod.GET)
		public ModelAndView getForm(Model model, @RequestParam(required = false) String tipoForm) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("locacao/form.locacao");
			mv.addObject("tipoForm", tipoForm);
			return mv;
		}
}