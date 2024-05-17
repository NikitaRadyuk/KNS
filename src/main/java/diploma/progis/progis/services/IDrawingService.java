package diploma.progis.progis.services;

import diploma.progis.progis.core.dto.AnswerDTO;
import diploma.progis.progis.core.dto.CreateDrawingDTO;

public interface IDrawingService {
    String drawStation(CreateDrawingDTO createDrawingDTO);
    AnswerDTO calculateAnswer(CreateDrawingDTO drawingDTO);
}
