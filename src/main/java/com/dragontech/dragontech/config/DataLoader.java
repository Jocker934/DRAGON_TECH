package com.dragontech.dragontech.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.dragontech.dragontech.model.Servicio;
import com.dragontech.dragontech.repository.ServicioRepository;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initServicios(ServicioRepository repo) {
        return args -> {
            if (repo.count() == 0) {

                // SOFTWARE FACTORY
                repo.save(create(
                        "Software Factory",
                        "software-factory",
                        "Diseño y desarrollo de software a medida, ERPs y plataformas escalables.",
                        "<p>Analizamos tus procesos de negocio y construimos soluciones de software a medida "
                                + "(web, móvil o escritorio) totalmente integradas con tus sistemas actuales.</p>"
                                + "<p>Trabajamos con arquitecturas modernas, APIs y buenas prácticas DevOps para que "
                                + "tus plataformas sean seguras, escalables y fáciles de mantener.</p>",
                        "/images/services/icons/icon-software.png",
                        "Ver más",
                        10
                ));

                // IA (DRAGONBOT)
                repo.save(create(
                        "Inteligencia Artificial (DragonBot)",
                        "ia-dragonbot",
                        "Chatbots inteligentes, análisis predictivo y automatización basada en IA.",
                        "<p>Diseñamos asistentes virtuales entrenados con la información de tu negocio para atender "
                                + "a tus clientes 24/7 y reducir tiempos de respuesta.</p>"
                                + "<p>Implementamos modelos de machine learning para segmentación, scoring, predicción "
                                + "de demanda y detección de anomalías, cuidando siempre la seguridad y la ética en el uso de datos.</p>",
                        "/images/services/icons/icon-dragonbot.png",
                        "Ver más",
                        20
                ));

                // CIBERSEGURIDAD (DRAGONSHIELD)
                repo.save(create(
                        "Ciberseguridad (DragonShield)",
                        "ciberseguridad-dragonshield",
                        "Servicios de ciberseguridad ofensiva y defensiva, monitoreo y cumplimiento normativo.",
                        "<p>Evaluamos el nivel de seguridad de tu infraestructura mediante pruebas de penetración, "
                                + "hardening de servidores, gestión de vulnerabilidades y monitoreo continuo.</p>"
                                + "<p>Te ayudamos a definir políticas, controles y planes de respuesta a incidentes "
                                + "alineados a estándares internacionales, para proteger tus datos y los de tus clientes.</p>",
                        "/images/services/icons/icon-dragonshield.png",
                        "Ver más",
                        30
                ));

                // AUTOMATIZACIÓN (DRAGONFLOW)
                repo.save(create(
                        "Automatización (DragonFlow)",
                        "automatizacion-dragonflow",
                        "Automatización de procesos (RPA) para eliminar tareas manuales y errores operativos.",
                        "<p>Identificamos tareas repetitivas en áreas como finanzas, logística o atención al cliente y "
                                + "las automatizamos con robots de software (RPA).</p>"
                                + "<p>Orquestamos flujos de trabajo, integramos bots con tus sistemas (ERP, CRM, correo, "
                                + "herramientas internas) y medimos el ahorro de tiempo y costos de cada automatización.</p>",
                        "/images/services/icons/icon-dragonflow.png",
                        "Ver más",
                        40
                ));

                // IOT & DATA ANALYTICS (DRAGONENERGY)
                repo.save(create(
                        "IoT & Data Analytics (DragonEnergy)",
                        "iot-dragonenergy",
                        "Soluciones IoT y analítica de datos en tiempo real para empresas e industria.",
                        "<p>Conectamos sensores, dispositivos y máquinas a plataformas en la nube para capturar datos "
                                + "en tiempo real y transformarlos en información accionable.</p>"
                                + "<p>Diseñamos dashboards personalizados, alertas inteligentes y modelos analíticos que te "
                                + "permiten anticipar fallas, optimizar el consumo de energía y tomar decisiones basadas en datos.</p>",
                        "/images/services/icons/icon-dragonenergy.png",
                        "Ver más",
                        50
                ));

                System.out.println("[DataLoader] Servicios iniciales creados");
            }
        };
    }

    private Servicio create(
            String nombre,
            String slug,
            String resumen,
            String descripcion,
            String icono,
            String cta,
            int orden
    ) {
        Servicio s = new Servicio();
        s.setNombre(nombre);
        s.setSlug(slug);
        s.setResumen(resumen);
        s.setDescripcion(descripcion);
        s.setIcono(icono);
        s.setCtaText(cta);
        s.setOrden(orden);
        s.setActivo(true);
        return s;
    }
}
