package com.feeltech.appbee.service.auxiliar;

import com.feeltech.appbee.model.Apiario;
import com.feeltech.appbee.model.Colmeia;
import com.feeltech.appbee.model.Endereco;
import com.feeltech.appbee.repository.*;
import com.feeltech.appbee.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

public class DBService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Autowired
    private ApiarioRepository apiarioRepository;

    @Autowired
    private ColmeiaRepository colmeiaRepository;

    @Autowired
    private ProducaoAnualRepository producaoAnualRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;



    public void instantiateTestDatabase() {

        Endereco ed1 = new Endereco(null, "57800-000", "sn");
        Endereco ed2 = new Endereco(null, "52490-005", "150");
        Endereco ed3 = new Endereco(null, "58140-000", "560");
        Endereco ed4 = new Endereco(null, "56800-000", "380");

        Apiario ap1 = new Apiario(null, "Apiario Florada Bela", "22411925000168", ed1);
        Apiario ap2 = new Apiario(null, "Apiario Flores do Sol", "20800277000106", ed2);
        Apiario ap3 = new Apiario(null, "Apiario Mel do Cerrado", "82480738000168", ed3);
        Apiario ap4 = new Apiario(null, "Apiario Mel do Campo", "18648126000132", ed4);

        Colmeia c1 = new Colmeia(null, "Colmeia Africana_01", "Apis mellifera", "Laranjeira", null, ap1);
        Colmeia c2 = new Colmeia(null, "Colmeia Africana_02", "Apis mellifera", "Laranjeira", null, ap1);
        Colmeia c3 = new Colmeia(null, "Colmeia Africana_03", "Apis mellifera", "Laranjeira", null, ap1);

        Colmeia c4 = new Colmeia(null, "Colmeia Jatai_01", "Tetragonisca angustula", "Flores Silvestres", null, ap2);
        Colmeia c5 = new Colmeia(null, "Colmeia Jatai_02", "Tetragonisca angustula", "Flores Silvestres", null, ap2);
        Colmeia c6 = new Colmeia(null, "Colmeia Jatai_03", "Tetragonisca angustula", "Flores Silvestres", null, ap2);

        Colmeia c7 = new Colmeia(null, "Colmeia Urucu_01", "Melipona rufiventris", "Flores do Cerrado", null, ap3);
        Colmeia c8 = new Colmeia(null, "Colmeia Urucu_02", "Melipona rufiventris", "Flores do Cerrado", null, ap3);
        Colmeia c9 = new Colmeia(null, "Colmeia Urucu_03", "Melipona rufiventris", "Flores do Cerrado", null, ap3);

        Colmeia c10 = new Colmeia(null, "Colmeia Mielera_01", "Melipona scutellaris", "Eucalipto", null, ap4);
        Colmeia c11 = new Colmeia(null, "Colmeia Mielera_01", "Melipona scutellaris", "Eucalipto", null, ap4);
        Colmeia c12 = new Colmeia(null, "Colmeia Mielera_01", "Melipona scutellaris", "Eucalipto", null, ap4);

        ap1.getColmeias().addAll(Arrays.asList(c1, c2, c3));
        ap2.getColmeias().addAll(Arrays.asList(c4, c5, c6));
        ap3.getColmeias().addAll(Arrays.asList(c7, c8, c9));
        ap4.getColmeias().addAll(Arrays.asList(c11, c12, c10));





    }
}
