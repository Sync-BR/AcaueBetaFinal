import express from "express";
import cors from "cors";

const app = express()


app.use(cors())


app.listen(8080, () => {
    console.log('Server is running on port 8080');
});


// app.use(cors({
//     origin: 'http://localhost:3000', 
//     methods: ['GET', 'POST'], 
//     allowedHeaders: ['Content-Type', 'Authorization'] 
// }));