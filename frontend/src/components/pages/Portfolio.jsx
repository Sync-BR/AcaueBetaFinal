import { useEffect, useState } from 'react'
import axios from 'axios'
const Portfolio = () => {

    const [data, setData] = useState([])

    console.log("dados projetos", data)

    useEffect(() => {
        axios.get('http://186.247.89.84:8080/AcaueBeta/webresources/generic/returnpost')
            .then((response) => {
                console.log("resposta ", response)
                setData(response.data);
            })
            .catch((err) => {
                console.error('Erro ao buscar os dados', err)
            })
    }, [])

    const imageDir = `./src/images/posts/`

    return (
        <>
            <h1>PORTFOLIO</h1>
            
            <div>
                {data.map((item, index) => (
                    <div key={index}>
                        <h4>Titulo: {item[0]}</h4>
                        <p>Descrição: {item[1]}</p>
                        <img src={`${imageDir}${item[2]}`} alt={item[2]} />
                      
                    </div>                   
                ))}
            </div>
        </>
    )
}

export default Portfolio