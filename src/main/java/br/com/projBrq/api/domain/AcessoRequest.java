package br.com.projBrq.api.domain;

import javax.validation.constraints.NotEmpty;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AcessoRequest {

	@NotNull
	@NotEmpty
	private String cep;

}
