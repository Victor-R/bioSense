package biosensews.dao;

public class FabricaDAO {

    private FabricaDAO() {

    }

    public static UsuarioDAO getUsuarioDAO() {
        return new UsuarioDAOImpl();
    }
    
    public static TipoPlantaDAO getTipoPlantaDAO() {
        return new TipoPlantaDAOImpl();
    }
    
    public static PlantaDAO getPlantaDAO() {
        return new PlantaDAOImpl();
    }
    
    public static LeituraDAO getLeituraDAO() {
        return new LeituraDAOImpl();
    }
}
