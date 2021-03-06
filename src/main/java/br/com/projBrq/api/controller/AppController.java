package br.com.projBrq.api.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.projBrq.api.Exceptions.AppException;
import br.com.projBrq.api.domain.AcessoRequest;
import br.com.projBrq.api.domain.AcessoResponse;
import br.com.projBrq.api.services.CepService;

@RestController
@RequestMapping("/cep")

public class AppController {

	@Autowired
	private CepService cepService;

	@PostMapping
	public ResponseEntity<AcessoResponse> buscaCep(@RequestBody @Valid AcessoRequest request) {
		ResponseEntity<AcessoResponse> response = null;
		try {
			AcessoResponse obterResposta = cepService.obterDadosAcessoResponse(request.getCep());
			return new ResponseEntity<AcessoResponse>(obterResposta, HttpStatus.OK);
		} catch (AppException app) {
			String msg = app.getMessage();
			HttpStatus status = HttpStatus.BAD_REQUEST;
			response = obterRespostaErro(msg, status);
			return response;
		} catch (Exception e) {
			return obterRespostaErro("Serviço indisponível", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	private ResponseEntity<AcessoResponse> obterRespostaErro(String msg, HttpStatus status) {
		ResponseEntity<AcessoResponse> response;
		AcessoResponse obterResposta = new AcessoResponse();
		obterResposta.setMensagem(msg);
		obterResposta.setCodigo(status.value());
		response = new ResponseEntity<>(obterResposta, status);
		return response;
	}

}
