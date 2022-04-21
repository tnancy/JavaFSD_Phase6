import { Product } from "./product";

export interface Cart {
    products: Product[];
    items: number;
    total: number;
}
