import { useEffect, useState } from 'react'
import axios from 'axios'
import { ToastContainer, toast } from 'react-toastify'
const Portfolio = () => {

    const [data, setData] = useState([])

    console.log("dados projetos", data)

    useEffect(() => {
        axios.get('https://zfaerp.hospedagemelastica.com.br/acaueBeta-1.0-SNAPSHOT/webresources/generic/returnpost')
            .then((response) => {
                console.log("resposta ", response)
                setData(response.data);
                toast.success('Projetos Recebidos!')
            })
            .catch((err) => {
                console.error('Erro ao buscar os dados', err)
                toast.error('Erro ao Receber os projetos.', {
                    closeOnClick: false,
                    draggable: true,
                    
                })
            })
    }, [])

    // const imageDir = `./src/images/posts/`

    return (
        <>
            <h1>PORTFOLIO</h1>
            <ToastContainer closeOnClick={true} />
            
            <div>
                {data.map((item, index) => (
                    <div key={index}>
                        <h4>Titulo: {item[0]}</h4>
                        <p>Descrição: {item[1]}</p>
                        {/* <img src={`${imageDir}${item[2]}`} alt={item[2]} /> */}
                      
                    </div>                   
                ))}
            </div>
        </>
    )
}

export default Portfolio