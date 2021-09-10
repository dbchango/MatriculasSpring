import axios from 'axios';
import authHeader from './auth_header';

const API_URL = 'http://localhost:8081/api/matriculacion/matricular-persona';

class ProductsService {
    createProduct(product){
        return axios.post(API_URL, {
            cedula_persona: product.cedula_persona, 
            nrc_curso: product.nrc_curso,
        }, { headers: authHeader() })
    }
}

export default new ProductsService();