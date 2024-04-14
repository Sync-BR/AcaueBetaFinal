import express from "express";
import { connectDB } from "./db.js";
import userRoutes from "./routes/user.js"
import cors from "cors";


const app  = express();

app.use(express.json());
app.use(cors());

app.use("/", userRoutes)

connectDB( ).then(() => {
    app.listen(8080, () => {
        console.log('Servidor Express iniciado na porta 8080');
    });
}).catch((err)=>{
    console.error('Erro ao iniciar o servidor:', err);
});
