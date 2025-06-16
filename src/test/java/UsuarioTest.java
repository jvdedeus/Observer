import org.example.ControleUpload;
import org.example.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    private ControleUpload controleUpload;
    private Usuario usuario;

    @BeforeEach
    void setUp() {
        controleUpload = new ControleUpload();
        usuario = new Usuario("João");
        controleUpload.addObserver(usuario);
    }

    @Test
    void deveNotificarUsuarioQuandoUploadConcluido() {
        controleUpload.concluirUpload();
        assertEquals("Concluído", usuario.getUltimaNotificacao());
    }

    @Test
    void deveNotificarUsuarioQuandoUploadCancelado() {
        controleUpload.cancelarUpload();
        assertEquals("Cancelado", usuario.getUltimaNotificacao());
    }

    @Test
    void deveNotificarUsuarioQuandoUploadPausado() {
        controleUpload.pausarUpload();
        assertEquals("Pausado", usuario.getUltimaNotificacao());
    }

    @Test
    void deveNotificarUsuarioAoPassarPorTodosOsStatus() {
        controleUpload.pausarUpload();
        assertEquals("Pausado", usuario.getUltimaNotificacao());

        controleUpload.concluirUpload();
        assertEquals("Concluído", usuario.getUltimaNotificacao());

        controleUpload.cancelarUpload();
        assertEquals("Cancelado", usuario.getUltimaNotificacao());
    }
}