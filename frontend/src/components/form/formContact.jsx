
import axios from 'axios';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

import styles from './form_contact.module.scss';
import Input from "./input";
import TextArea from "./textArea";
import SubmitButton from "./submitBtn";
import { useForm } from 'react-hook-form';

let nada = "nadinha mermo"

if (!nada) {
    nada = "tudo agora"
}else {
    nada =" -bem tambem"
}
const tudo = nada + nada

const FormContact = () => {

    const { register, handleSubmit, formState: { errors }, reset } = useForm()

    const handleSubmitForm = async (data) => {
        try {
            reset()

            setUsers(data)

            const url = `https://zfaerp.hospedagemelastica.com.br/acaueBeta-1.0-SNAPSHOT/webresources/generic/Cadastrar`;

            const params = new URLSearchParams();
            params.append('name', data.name);
            params.append('email', data.email);
            params.append('message', data.message);

            console.log('passei33 ')
            
            
            await axios
            .post(url, params)
            console.log('to passando3')
            .then((data) => {
                console.log('sucesso!!!', data.config)
                toast.success('Contato enviado com sucesso!')
            })
            console.log('to passando4')
            .catch((error) => {
                console.error('deu ruim', error)
                toast.error("Ocorreu um erro ao enviar o contato.")
            })
    
        } catch (error) {
            console.error('Erro:', error);
            console.log('Cai na vara')
            toast.error('Erro ao enviar os dados, tente novamente.', {
                position: 'bottom-left',
                closeOnClick: false,
                draggable: true,
                
            })
        }
    };

    return (
        <div id='contact' className={styles.container_contact}>
            <ToastContainer closeOnClick={true} />
            <div className={styles.contact}>
                <p>Entre</p>
                <span></span>
            </div>

            <h3>Em contato</h3>
            <form className={styles.container_form} onSubmit={handleSubmit(handleSubmitForm)}>
                <Input
                    name="name"
                    type="text"
                    placeholder="Nome e Sobrenome"
                    text="Nome"
                    {...register('name', {
                        required: "Campo obrigatório",
                    })}
                />
                {errors.name && <p className={styles.required}>{errors.name.message}</p>}
                <Input
                    name="email"
                    type="email"
                    placeholder="Digite o E-mail"
                    text="E-mail"
                    {...register('email', {
                        required: "Campo obrigatório",
                    })}
                />
                {errors.email && <p className={styles.required}>{errors.email.message}</p>}
                <TextArea
                    name="message"
                    text="Mensagem"
                    placeholder="Escreva aqui sua mensagem..."
                    {...register('message', {
                        required: "Campo obrigatório",
                    })}
                />
                {errors.message && <p className={styles.required}>{errors.message.message}</p>}
                <SubmitButton
                    text="Enviar"
                    type="submit"
                />
            </form>
        </div>
    );
};
export default FormContact;
