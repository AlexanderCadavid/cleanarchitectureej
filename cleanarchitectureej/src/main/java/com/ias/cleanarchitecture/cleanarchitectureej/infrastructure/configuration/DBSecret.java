package com.ias.cleanarchitecture.cleanarchitectureej.infrastructure.configuration;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DBSecret {

	private final String url;

}
