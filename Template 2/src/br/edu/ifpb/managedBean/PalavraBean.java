package br.edu.ifpb.managedBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import javax.faces.event.ActionEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ViewScoped
@ManagedBean
public class PalavraBean {
	
		private Logger logger = LogManager.getLogger(PalavraBean.class);
		
		private String palavra;
		
		List<String> palavras;
		
		private MenuModel model;
		 
	    public void init() {
	        model = new DefaultMenuModel();
	         
	        //First submenu
	        DefaultSubMenu firstSubmenu = new DefaultSubMenu("Dynamic Submenu");
	         
	        DefaultMenuItem item = new DefaultMenuItem("External");
	        item.setUrl("http://www.primefaces.org");
	        item.setIcon("ui-icon-home");
	        firstSubmenu.addElement(item);
	         
	        model.addElement(firstSubmenu);
	    }
		
		
		public PalavraBean() {
			
			this.palavras = new ArrayList<String>();
		}
		
		public String buscar() {
			
			logger.info("Palavra: " + palavra);
			
			return null;
		}
		
		public void listenerKeyup(AjaxBehaviorEvent e) {
			
			System.out.println("Palavra: " + palavra);
			
			logger.info("Palavra: " + palavra);
			
			palavras.add(palavra);
		}

		public List<String> getPalavras() {		
			return palavras;
		}

		public void setPalavras(List<String> palavras) {
			this.palavras = palavras;
		}

		public String getPalavra() {
			return palavra;
		}

		public void setPalavra(String palavra) {
			this.palavra = palavra;
		}
		
		public String buttonAction(ActionEvent actionEvent) throws IOException {

			FacesContext context = FacesContext.getCurrentInstance();

			NavigationHandler navHandler = context.getApplication().getNavigationHandler();

			navHandler.handleNavigation(context, null, "busca");
			return palavra;
			
	    }
		
		public String inserir (AjaxBehaviorEvent e) {
				
				System.out.println("Palavra: " + palavra);
				
				logger.info("Palavra: " + palavra);
				
				palavras.add(palavra);
				return palavra;
		}
		
		public void addMessage(String summary) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }
}
