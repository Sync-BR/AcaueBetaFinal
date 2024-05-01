
import axios from 'axios';

import { useUsers } from '../contexts/usersContext';

import styles from './form_contact.module.scss';
import Input from "./input";
import TextArea from "./textArea";
import SubmitButton from "./submitBtn";
import { useForm } from 'react-hook-form';

const FormContact = () => {
    const { register, handleSubmit, formState: { errors }, reset } = useForm();
    const { users, setUsers } = useUsers();



    const handleSubmitForm = async (data) => {
        try {
            reset()

            setUsers(data)

            const url = `https://zfaerp.hospedagemelastica.com.br/acaueBeta-1.0-SNAPSHOT/webresources/generic/Cadastrar`;

            const params = new URLSearchParams();
            params.append('name', data.name);
            params.append('email', data.email);
            params.append('message', data.message);

            await axios
            .post(url, params)
            .then((data) => data.config)
            .then((data) => console.log("sucesso! ", data.data))
            .catch((data) => console.error("deu ruim", data))
    
        } catch (error) {
            console.error('Erro:', error);
            alert('Erro ao enviar dados. Por favor, tente novamente.');
        }
    };

    return (
        <div id='contact' className={styles.container_contact}>
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
