import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'
// import dns from 'node:dns'

// dns.setDefaultResultOrder('verbatim')


const port = 3000;
// const host = "0.0.0.0";

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [react()],
  server: {
    // host: host,
    port: port

  }

})
