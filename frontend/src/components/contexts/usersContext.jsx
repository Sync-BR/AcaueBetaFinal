import React, { createContext, useContext, useState } from 'react';

// Criar o contexto
const UsersContext = createContext();

// Provedor do contexto que envolve toda a sua aplicação
export const UsersProvider = ({ children }) => {
  const [users, setUsers] = useState([]);
  // console.log("uzii", users)

  return (
    <UsersContext.Provider value={{ users, setUsers }}>
      {children}
    </UsersContext.Provider>
  );
};

// Hook personalizado para acessar o contexto
export const useUsers = () => useContext(UsersContext);