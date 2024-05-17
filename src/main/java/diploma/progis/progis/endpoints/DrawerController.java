package diploma.progis.progis.endpoints;

import diploma.progis.progis.core.dto.AnswerDTO;
import diploma.progis.progis.core.dto.CreateDrawingDTO;
import diploma.progis.progis.services.DXFSaver;
import diploma.progis.progis.services.IDrawingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/calc")
@Slf4j
public class DrawerController {
    private final IDrawingService drawingService;

    public DrawerController(IDrawingService drawingService) {
        this.drawingService = drawingService;
    }

    @PostMapping
    public AnswerDTO calculate(@RequestBody CreateDrawingDTO createDrawingDTO){
        return this.drawingService.calculateAnswer(createDrawingDTO);
    }
    
    @PostMapping("/dxf")
    public byte[] saveDXF(@RequestBody CreateDrawingDTO createDrawingDTO){
        String  str = this.drawingService.drawStation(createDrawingDTO);
        DXFSaver dxfSaver = new DXFSaver();
        byte[] bytes = dxfSaver.toDXF(str.getBytes(StandardCharsets.UTF_8));
        return bytes;
    }
}
