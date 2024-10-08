import http from 'k6/http';
import { sleep, check } from 'k6';

// Definir la URL del endpoint
const url = 'https://reqres.in/api/users';

// Configuración de K6 con carga más significativa
export let options = {
    stages: [
        { duration: '1m', target: 20 },    // Aumenta a 20 VUs en 1 minuto
        { duration: '1m', target: 100 },    // Aumenta a 100 VUs en 1 minuto
        { duration: '2m', target: 100 },    // Mantiene 100 VUs durante 2 minutos
        { duration: '30s', target: 200 },   // Aumenta a 200 VUs en 30 segundos
        { duration: '2m', target: 200 },     // Mantiene 200 VUs durante 2 minutos
        { duration: '1m', target: 400 },    // Aumenta a 400 VUs en 1 minuto
        { duration: '2m', target: 400 },     // Mantiene 400 VUs durante 2 minutos
        { duration: '30s', target: 0 }       // Reduce a 0 VUs en 30 segundos
    ],
    thresholds: {
        http_req_duration: ['p(95)<1000'], // 95% de las solicitudes deben estar por debajo de 1000ms
    },
};

// Función principal que se ejecuta
export default function () {
    const response = http.get(url);
    
    // Validar el código de estado
    check(response, {
        'is status 200': (r) => r.status === 200,
    });

    // Esperar un segundo entre las solicitudes
    sleep(1);
}
