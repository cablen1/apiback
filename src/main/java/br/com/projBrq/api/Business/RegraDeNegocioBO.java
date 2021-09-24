package br.com.projBrq.api.Business;

import org.springframework.stereotype.Service;
import br.com.projBrq.api.Exceptions.AppException;
import br.com.projBrq.api.domain.AcessoRequest;
import br.com.projBrq.api.domain.AcessoResponse;

@Service
public class RegraDeNegocioBO {

	public AcessoResponse validaCep(AcessoRequest acessoRequest) {

		AcessoResponse response = new AcessoResponse();
		if (acessoRequest.getCep().length() < 8) {
			throw new AppException("Digite um CEP valido");
		} else if (acessoRequest.getCep().length() > 9) {
			throw new AppException("Digite um CEP valido");
		} else if (acessoRequest == null) {
			throw new AppException("Valor nao pode ser nulo, digite um valor valido!");
		}
		return response;
	}
}
