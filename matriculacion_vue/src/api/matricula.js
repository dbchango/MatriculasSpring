import axios from 'axios';
import authHeader from './auth_header';

const API_URL = 'https://webapiingseg.azurewebsites.net/api/Products';

class ProductsService {
    getProducts(){
        return axios.get(API_URL, { headers: authHeader() })
        
    }
    deleteProduct(id){
        return axios.delete(API_URL+'/'+id, { headers: authHeader() })
    }
    retrieveProduct(id){
        return axios.get(API_URL+'/'+id, { headers: authHeader() })
    }
    editProduct(product){
        return axios.put(API_URL+'/'+product.Id, product, { headers: authHeader() })
    }
    createProduct(product){
        return axios.post(API_URL, {
            Name: product.Name, 
            Details: product.Details,
            Price: product.Price,
            Weight: product.Weight,
            Stock: product.Stock
        }, { headers: authHeader() })
    }
}

export default new ProductsService();