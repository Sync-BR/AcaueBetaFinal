import mysql from "mysql"

const db = mysql.createConnection({
    host: "186.247.89.84",
    user: "YanDarkBR",
    password: "33910114",
    database: "acauebeta"
})

// Estabelecendo conexão com o banco de dados

function connectDB() {
    return new Promise((resolve, reject) => {
        db.connect((err) => {
            if (err) {
                console.error('Erro ao conectar com o banco de dados:', err)
                reject(err);
                return;
            }
            console.log('Conectado com sucesso, ao banco de dados!')
            resolve();
        });
    });
};


export { db, connectDB }

