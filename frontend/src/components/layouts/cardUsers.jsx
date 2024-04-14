import styles from './card_users.module.scss';

const CardUsers = ({ users, deleteUser }) => {
   

    return (
        <div  className={styles.container}>
            <h2>Lista de Usuários</h2>
            {users.map(user => (
                <ul className={styles.container_card} key={user.id || user.email || user.name}>
                    <li>
                        Nome: {user.name}
                    </li>
                    <li>
                        Email: {user.email}
                    </li>
                    <li>
                        Mensagem: {user.message}
                    </li>
                    <button onClick={() => deleteUser(user.id)}>Deletar</button>
                </ul>
            ))}
        </div>
    )
}

export default CardUsers