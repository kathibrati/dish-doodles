package de.kathibrati.dishdoodles.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {

  private String name;
  private String description;
  private String imageUrl;
  private Unit unit;
  private List<NutritionalInformation> nutritionalInformationList;

}
