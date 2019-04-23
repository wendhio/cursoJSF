package br.com.integrator.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Controle {
	private MeuBean meuBean;
	
	public Controle(){
		meuBean = new MeuBean();
	}
	
	public String acao(){
		boolean sucesso = true;
		FacesContext contexto = FacesContext.getCurrentInstance();
		if(meuBean.getNome() != null){
			for(int i = 0; i < meuBean.getNome().length(); i++){
				char c = meuBean.getNome().charAt(i);
				if(!Character.isLetter(c) && !Character.isSpaceChar(c)){
					String msg = "Digite somente caracteres alfabéticos.";
					FacesMessage message = new FacesMessage(msg);
					contexto.addMessage("formulario", message);
					sucesso = false;
					break;
				}
			}
		}else{
			sucesso = false;
		}
		return (sucesso ? "sucesso!" : "falha!");
	}
}
