package dao;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import jogo.Jogo;

/**
 *
 * Created by LuisFelipe.
 */
public class TermoDatabase
{
    private static final String TermoDesconhecido_XML = "termoDesconhecido.xml";

    public TermoDatabase()
    {
    }


    public void salvarJogo(Jogo jogo) throws IOException
    {
        try (XMLEncoder xmlEncoder = new XMLEncoder(new FileOutputStream(TermoDesconhecido_XML))) {
            xmlEncoder.writeObject(jogo);
        }
    }

    public Jogo recuperarJogo() throws IOException
    {
        Jogo jogo = new Jogo();
        File arquivo = new File(TermoDesconhecido_XML);
        if (arquivo.exists()) {
            try (XMLDecoder xmlDecoder = new XMLDecoder(new FileInputStream(TermoDesconhecido_XML))) {
                jogo = (Jogo) xmlDecoder.readObject();
            }
        }

        return jogo;
    }
}
