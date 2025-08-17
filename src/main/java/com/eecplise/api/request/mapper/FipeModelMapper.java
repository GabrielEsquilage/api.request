package com.eecplise.api.request.mapper;

import com.eecplise.api.request.dto.FipeCodeResponseDTO;
import com.eecplise.api.request.entity.fipe.Model;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")

public interface FipeModelMapper {
  @Mapping(source = "fipeCode", target = "fipe_code")
  @Mapping(source = "years", target = "year")
  FipeCodeResponseDTO toDto(Model model);
  List<FipeCodeResponseDTO> toDtoList(List<Model> models);
}
