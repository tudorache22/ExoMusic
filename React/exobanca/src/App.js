import logo from './logo.svg';
import './App.css';
import { createContext, useState } from 'react';
import Header from './Header/Header';
import Main from './Main/Main';
import NavBar from './NavBar/NavBar';
import Footer from './Footer/Footer';
import SideBar from './SideBar/SideBar';

export const UtenteContext = createContext();
export const ConnessoContext = createContext();
export const AnagraficaContext = createContext();
export const ContoCorrenteContext = createContext();
export const MovimentoContext = createContext();

function App() {

  const [anagrafica, setAnagrafica] = useState({
    codiceFiscale: "",
    cognome: "",
    dataNascita: "",
    idAnagrafica: "",
    luogoNascita: "",
    nome: "",
    provincia: "",
    sesso: ""
  })

  const [utente, setUtente] = useState({
    idUtente: "",
    password: "",
    email: "",
    ruolo: "",
    anagrafica: anagrafica
  })

  const [connesso, setConnesso] = useState(false);

  const [contoCorrente, setContoCorrente] = useState({
    numeroConto: "",
    dataScadenza: "",
    saldo: ""
  })

  const [movimento, setMovimento] = useState({
    idTransazione: "",
    data: "",
    importo: "",
    stato: "",
    tipoTransazione: ""
  })

  const connessoContext = {
    connesso: connesso,
    setConnesso: setConnesso
  }

  const anagraficaContext = {
    anagrafica: anagrafica,
    setAnagrafica: setAnagrafica
  }

  const utenteContext = {
    utente: utente,
    setUtente: setUtente
  };

  const contoCorrenteContext = {
    contoCorrente: contoCorrente,
    setContoCorrente: setContoCorrente
  }

  const movimentoContext = {
    movimento: movimento,
    setMovimento: setMovimento
  }


  return (
    <div className='row'>
      <UtenteContext.Provider value={utenteContext}>
        <AnagraficaContext.Provider value={anagraficaContext}>
          <ConnessoContext.Provider value={connessoContext}>
            <ContoCorrenteContext.Provider value={contoCorrenteContext}>
              <MovimentoContext.Provider value={movimentoContext}>
                <div className='col-12'>
                  <Header />
                </div>
                <div className='col-12'>
                  <SideBar />
                </div>
                <div className='col-12'>
                  <Main />
                </div>
                <div className='col-12'>
                  <Footer />
                </div>
              </MovimentoContext.Provider>
            </ContoCorrenteContext.Provider>
          </ConnessoContext.Provider>
        </AnagraficaContext.Provider>
      </UtenteContext.Provider>
    </div>
  )
}

export default App;
