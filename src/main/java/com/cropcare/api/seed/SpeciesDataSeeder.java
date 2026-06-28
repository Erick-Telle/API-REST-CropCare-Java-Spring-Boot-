package com.cropcare.api.seed;

import com.cropcare.api.entity.ClimateFactor;
import com.cropcare.api.entity.Species;
import com.cropcare.api.repository.ClimateFactorRepository;
import com.cropcare.api.repository.SpeciesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SpeciesDataSeeder implements CommandLineRunner {

    private final SpeciesRepository speciesRepository;
    private final ClimateFactorRepository climateFactorRepository;

    public SpeciesDataSeeder(SpeciesRepository speciesRepository,
                             ClimateFactorRepository climateFactorRepository) {
        this.speciesRepository = speciesRepository;
        this.climateFactorRepository = climateFactorRepository;
    }

    @Override
    public void run(String... args) {
        if (speciesRepository.count() == 0) {
            seedSpecies();
        }
        if (climateFactorRepository.count() == 0) {
            seedClimateFactors();
        }
    }

    private void seedSpecies() {
        speciesRepository.saveAll(java.util.List.of(
                createSpecies("Cactus de barril", "Ferocactus wislizeni", 21, 80, 1.3f, 0.8f,
                        "Requiere luz directa durante al menos 6 horas al día. Colócalo cerca de una ventana orientada al sur.",
                        "Tolera ambientes secos. Evita la humedad excesiva; un 30-40% de humedad relativa es ideal.",
                        "Abónalo una vez al mes en primavera y verano con fertilizante para cactus diluido al 50%."),
                createSpecies("Suculenta Echeveria", "Echeveria elegans", 14, 60, 1.2f, 0.85f,
                        "Prefiere luz brillante indirecta. Puede tolerar algunas horas de sol directo suave por la mañana.",
                        "Ambiente seco a moderado. No rocíes las hojas; la humedad alta puede causar podredumbre.",
                        "Fertiliza cada 6-8 semanas en temporada de crecimiento con abono líquido para suculentas."),
                createSpecies("Pothos", "Epipremnum aureum", 7, 150, 1.0f, 1.1f,
                        "Tolera poca luz pero crece mejor con luz indirecta brillante. Evita el sol directo intenso.",
                        "Prefiere humedad moderada-alta (50-70%). Rocía las hojas ocasionalmente en ambientes secos.",
                        "Abona cada 4-6 semanas en primavera y verano con fertilizante balanceado diluido."),
                createSpecies("Monstera", "Monstera deliciosa", 7, 200, 1.0f, 1.15f,
                        "Necesita luz indirecta brillante. Evita la luz solar directa que quema sus hojas.",
                        "Prefiere humedad alta (60-80%). Usa un humidificador o bandeja con agua y piedras.",
                        "Fertiliza mensualmente en primavera y verano con abono líquido 20-20-20 diluido."),
                createSpecies("Sansevieria", "Sansevieria trifasciata", 14, 100, 0.9f, 0.9f,
                        "Muy adaptable: tolera poca luz pero prefiere luz indirecta media a brillante.",
                        "Tolera ambientes secos. Ideal para habitaciones con calefacción o aire acondicionado.",
                        "Abona 2-3 veces al año en primavera y verano con fertilizante para plantas de interior."),
                createSpecies("Ficus lyrata", "Ficus lyrata", 10, 250, 1.0f, 1.1f,
                        "Requiere luz indirecta brillante y constante. Gira la maceta cada semana para crecimiento uniforme.",
                        "Prefiere humedad del 50-60%. Limpia las hojas grandes con un paño húmedo para mejor fotosíntesis.",
                        "Abona mensualmente de primavera a otoño con fertilizante balanceado para plantas de follaje."),
                createSpecies("Orquídea Phalaenopsis", "Phalaenopsis amabilis", 10, 80, 1.05f, 1.2f,
                        "Luz indirecta brillante sin sol directo. Una ventana este u oeste con cortina translúcida es ideal.",
                        "Necesita humedad del 50-70%. Coloca la maceta sobre un plato con piedras húmedas.",
                        "Usa fertilizante específico para orquídeas cada 2 semanas durante el crecimiento activo."),
                createSpecies("Lavanda", "Lavandula angustifolia", 10, 120, 1.1f, 0.95f,
                        "Requiere al menos 6 horas de sol directo al día. Ideal para balcones o ventanas muy luminosas.",
                        "Prefiere ambientes secos con buena circulación de aire. Evita la humedad excesiva.",
                        "Abona ligeramente en primavera con fertilizante bajo en nitrógeno para favorecer las flores."),
                createSpecies("Albahaca", "Ocimum basilicum", 3, 100, 1.15f, 1.1f,
                        "Necesita 6-8 horas de luz directa o muy brillante. Crece mejor cerca de una ventana soleada.",
                        "Prefiere humedad moderada (40-60%). Mantén el sustrato húmedo pero nunca encharcado.",
                        "Abona cada 2-3 semanas con fertilizante orgánico líquido para hierbas aromáticas."),
                createSpecies("Helecho de Boston", "Nephrolepis exaltata", 4, 180, 0.95f, 1.25f,
                        "Prefiere luz indirecta suave. Evita el sol directo que amarillea y quema los frondes.",
                        "Requiere humedad alta (60-80%). Rocía diariamente o usa humidificador en invierno.",
                        "Abona cada 4 semanas en primavera y verano con fertilizante diluido para helechos."),
                createSpecies("Aloe Vera", "Aloe barbadensis miller", 14, 90, 1.2f, 0.85f,
                        "Luz indirecta brillante a sol parcial. Tolera sol directo suave por la mañana.",
                        "Ambiente seco. Deja secar completamente el sustrato entre riegos.",
                        "Fertiliza 2-3 veces al año en verano con abono diluido para cactus y suculentas."),
                createSpecies("Spatifilo", "Spathiphyllum wallisii", 5, 200, 0.95f, 1.2f,
                        "Tolera poca luz pero florece mejor con luz indirecta media. Evita el sol directo.",
                        "Prefiere humedad alta. Las hojas caídas indican falta de agua; las puntas marrones, exceso de sol seco.",
                        "Abona cada 6-8 semanas con fertilizante balanceado durante la primavera y el verano."),
                createSpecies("Dracaena marginata", "Dracaena marginata", 10, 150, 1.0f, 1.05f,
                        "Luz indirecta media a brillante. Tolera condiciones de poca luz pero crece más lento.",
                        "Prefiere humedad del 40-50%. Evita el exceso de agua en la base del tronco.",
                        "Fertiliza mensualmente en temporada activa con abono líquido diluido al 50%."),
                createSpecies("Calathea", "Calathea ornata", 5, 160, 0.9f, 1.3f,
                        "Luz indirecta suave sin sol directo. Ideal para habitaciones con luz filtrada.",
                        "Requiere humedad muy alta (70%+). Rocía las hojas con agua destilada para evitar manchas.",
                        "Abona cada 4 semanas en primavera y verano con fertilizante diluido para plantas tropicales."),
                createSpecies("Jade", "Crassula ovata", 14, 70, 1.15f, 0.9f,
                        "Luz indirecta brillante con 4 horas de sol directo suave. Insuficiente luz produce tallos débiles.",
                        "Ambiente seco a moderado. Riega solo cuando el sustrato esté completamente seco.",
                        "Abona 2 veces al año en primavera y verano con fertilizante para suculentas."),
                createSpecies("Peperomia", "Peperomia obtusifolia", 10, 80, 1.0f, 1.1f,
                        "Luz indirecta media. Tolera espacios con poca luz pero prefiere ambientes luminosos.",
                        "Humedad moderada (40-50%). No necesita rociado frecuente; evita encharcar el sustrato.",
                        "Fertiliza cada 6-8 semanas en primavera con abono balanceado muy diluido."),
                createSpecies("Anturio", "Anthurium andraeanum", 5, 150, 1.0f, 1.2f,
                        "Luz indirecta brillante sin sol directo. Insuficiente luz reduce la floración.",
                        "Prefiere humedad del 60-80%. Mantén el sustrato ligeramente húmedo, nunca empapado.",
                        "Abona cada 6-8 semanas con fertilizante alto en fósforo para favorecer las flores."),
                createSpecies("Croton", "Codiaeum variegatum", 5, 180, 1.05f, 1.15f,
                        "Requiere luz indirecta brillante para mantener sus colores vivos. Poca luz apaga el follaje.",
                        "Prefiere humedad del 50-60%. Rocía las hojas en ambientes secos con calefacción.",
                        "Fertiliza mensualmente de marzo a septiembre con abono balanceado para plantas de interior."),
                createSpecies("Begonia rex", "Begonia rex-cultorum", 5, 120, 0.95f, 1.2f,
                        "Luz indirecta brillante sin sol directo. Ideal cerca de ventanas con cortina translúcida.",
                        "Necesita humedad del 50-60%. Evita mojar las hojas al regar para prevenir hongos.",
                        "Abona cada 4 semanas en temporada activa con fertilizante diluido para begonias."),
                createSpecies("Palmera areca", "Dypsis lutescens", 5, 250, 1.0f, 1.15f,
                        "Luz indirecta brillante. Tolera algo de sol matutino pero no el sol intenso del mediodía.",
                        "Prefiere humedad del 50-60%. Limpia las hojas con un paño húmedo para eliminar polvo.",
                        "Fertiliza mensualmente en primavera y verano con abono para palmeras o plantas verdes."),
                createSpecies("Menta", "Mentha spicata", 3, 100, 1.1f, 1.15f,
                        "Requiere luz directa parcial o muy brillante. Crece vigorosamente con buena iluminación.",
                        "Prefiere humedad moderada-alta. No dejes secar completamente el sustrato.",
                        "Abona cada 3-4 semanas con fertilizante orgánico líquido para hierbas culinarias."),
                createSpecies("Cactus de Navidad", "Schlumbergera truncata", 10, 100, 0.95f, 1.1f,
                        "Luz indirecta brillante. Evita el sol directo intenso que puede quemar los segmentos.",
                        "Humedad moderada (50-60%). Aumenta ligeramente la humedad durante la floración.",
                        "Abona cada 2-3 semanas en otoño y primavera con fertilizante bajo en nitrógeno."),
                createSpecies("Filodendro", "Philodendron hederaceum", 7, 150, 1.0f, 1.1f,
                        "Tolera poca luz pero crece más rápido con luz indirecta media a brillante.",
                        "Prefiere humedad del 50-60%. Rocía ocasionalmente en ambientes con calefacción.",
                        "Fertiliza cada 4-6 semanas en primavera y verano con abono balanceado diluido.")
        ));
    }

    private Species createSpecies(String nombreComun, String nombreCientifico,
                                  int frecuencia, int agua, float temp, float humedad,
                                  String luz, String humedadConsejo, String abono) {
        Species species = new Species();
        species.setNombreComun(nombreComun);
        species.setNombreCientifico(nombreCientifico);
        species.setFrecuenciaBaseDias(frecuencia);
        species.setCantidadBaseAguaMl(agua);
        species.setAjustePorTemperatura(temp);
        species.setAjustePorHumedad(humedad);
        species.setConsejosLuz(luz);
        species.setConsejosHumedad(humedadConsejo);
        species.setConsejosAbono(abono);
        return species;
    }

    private void seedClimateFactors() {
        climateFactorRepository.saveAll(java.util.List.of(
                factor("ESTACION", "PRIMAVERA", 1.0f, "Temporada de crecimiento activo, riego estándar"),
                factor("ESTACION", "VERANO", 1.3f, "Mayor evaporación, incrementar frecuencia de riego"),
                factor("ESTACION", "OTONO", 0.9f, "Crecimiento más lento, reducir ligeramente el riego"),
                factor("ESTACION", "INVIERNO", 0.7f, "Latencia o reposo, riego mínimo"),
                factor("TEMPERATURA", "BAJA", 0.8f, "Por debajo de 15°C, las plantas consumen menos agua"),
                factor("TEMPERATURA", "MEDIA", 1.0f, "Entre 15°C y 25°C, condiciones ideales"),
                factor("TEMPERATURA", "ALTA", 1.25f, "Por encima de 25°C, mayor necesidad de hidratación"),
                factor("HUMEDAD", "BAJA", 1.2f, "Humedad relativa menor al 40%, el sustrato se seca más rápido"),
                factor("HUMEDAD", "MEDIA", 1.0f, "Humedad relativa entre 40% y 60%, condiciones normales"),
                factor("HUMEDAD", "ALTA", 0.85f, "Humedad relativa mayor al 60%, reducir frecuencia de riego")
        ));
    }

    private ClimateFactor factor(String tipo, String valor, float mult, String desc) {
        ClimateFactor cf = new ClimateFactor();
        cf.setTipoFactor(tipo);
        cf.setValorCondicion(valor);
        cf.setMultiplicador(mult);
        cf.setDescripcion(desc);
        return cf;
    }
}
