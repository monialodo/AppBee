package com.feeltech.appbee.service.auxiliar;

import com.feeltech.appbee.model.*;
import com.feeltech.appbee.repository.*;
import com.feeltech.appbee.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private AmbienteConfigRepository ambienteConfigRepository;

    @Autowired
    private ApiarioRepository apiarioRepository;

    @Autowired
    private ColmeiaRepository colmeiaRepository;

    @Autowired
    private ProducaoAnualRepository producaoAnualRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ViaCepService viaCepService;



    public void instantiateTestDatabase() {

        Endereco ed1 = viaCepService.findByCep("57800-000");
        ed1.setNumero("sn");

        Endereco ed2 = viaCepService.findByCep("52490-005");
        ed2.setNumero("150");

        Endereco ed3 = viaCepService.findByCep("58140-000");
        ed3.setNumero("560");

        Endereco ed4 = viaCepService.findByCep("56800-000");
        ed4.setNumero("380");

        Endereco ed5 = viaCepService.findByCep("58038-330");
        ed5.setNumero("416");

        enderecoRepository.saveAll(Arrays.asList(ed1, ed2, ed3, ed4, ed5));


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

        apiarioRepository.saveAll(Arrays.asList(ap1, ap2, ap3, ap4));
        colmeiaRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12));

        ProducaoAnual pa1 = new ProducaoAnual(null, "2022", 10.0, 2.0, 0.5, c1);
        ProducaoAnual pa2 = new ProducaoAnual(null, "2022", 15.0, 3.0, 0.8, c2);
        ProducaoAnual pa3 = new ProducaoAnual(null, "2022", 20.0, 4.0, 1.2, c3);
        ProducaoAnual pa4 = new ProducaoAnual(null, "2022", 18.0, 3.5, 1.0, c4);
        ProducaoAnual pa5 = new ProducaoAnual(null, "2022", 10.0, 2.0, 0.5, c5);
        ProducaoAnual pa6 = new ProducaoAnual(null, "2022", 15.0, 3.0, 0.8, c6);
        ProducaoAnual pa7 = new ProducaoAnual(null, "2022", 20.0, 4.0, 1.2, c7);
        ProducaoAnual pa8 = new ProducaoAnual(null, "2022", 18.0, 3.5, 1.0, c8);
        ProducaoAnual pa9 = new ProducaoAnual(null, "2022", 10.0, 2.0, 0.5, c9);
        ProducaoAnual pa10 = new ProducaoAnual(null, "2022", 15.0, 3.0, 0.8, c10);
        ProducaoAnual pa11 = new ProducaoAnual(null, "2022", 20.0, 4.0, 1.2, c11);
        ProducaoAnual pa12 = new ProducaoAnual(null, "2022", 18.0, 3.5, 1.0, c12);

        producaoAnualRepository.saveAll(Arrays.asList(pa1, pa2, pa3, pa4, pa5, pa6, pa7, pa8, pa9, pa10, pa11, pa12));

        Usuario usr1 = new Usuario(null, "Monia Lodo", "", null, "", "81999999999", "ADMIN", ed5, null);

        usuarioRepository.save(usr1);





    }
}
