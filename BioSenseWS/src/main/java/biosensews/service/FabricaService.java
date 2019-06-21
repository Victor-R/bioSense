package biosensews.service;

public class FabricaService {

    private FabricaService() {

    }

    public static UsuarioService getUsuarioService() {
        return new UsuarioServiceImpl();
    }
    
    public static TipoPlantaService getTipoPlantaService() {
        return new TipoPlantaServiceImpl();
    } 
    
    public static PlantaService getPlantaService() {
        return new PlantaServiceImpl();
    }
    
    public static LeituraService getLeituraService() {
        return new LeituraServiceImpl();
    }
}
