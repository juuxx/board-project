package com.juu.board.springboot.dto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HelloResponseDtoTest {

	@DisplayName("롬복 기능 테스트")
	@Test
	void lombok_test() {
		//given
		String name = "test";
		int amount = 1000;

		//when
		HelloResponseDto dto = new HelloResponseDto(name, amount);

		//then
		assertThat(dto.getName()).isEqualTo(name);
		assertThat(dto.getAmount()).isEqualTo(amount);
	}
}