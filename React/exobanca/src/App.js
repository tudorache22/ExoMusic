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
export const OtpContext = createContext();
export const NotificheContext = createContext();
export const UtenteSelezionatoContext = createContext();
export const AllTransazioniContext = createContext();
export const AllContiContext = createContext();

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
    anagrafica: anagrafica,
    transaziones: [],
    contoCorrentes: []
  })

  const [connesso, setConnesso] = useState(false);

  const [contoCorrente, setContoCorrente] = useState({
    idContoCorrente: "",
    numeroConto: "",
    dataScadenza: "",
    saldo: ""
  })

  const [movimento, setMovimento] = useState({
    idTransazione: "",
    importo: "",
    stato: "",
    tipoTransazione: "",
    data: ""
  })

  const [otp, setOtp] = useState({
    codice: "",
  })

  const [notifiche, setNotifiche] = useState([])

  const [utenteSelezionato, setUtenteSelezionato] = useState({
    idUtente: "",
    password: "",
    email: "",
    ruolo: "",
    anagrafica: anagrafica,
    transaziones: [],
    contoCorrentes: []
  })

  const [allTransazioni, setAllTransazioni] = useState([])

  const [allConti, setAllConti] = useState([])

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

  const otpContext = {
    otp: otp,
    setOtp: setOtp
  }

  const notificheContext = {
    notifiche: notifiche,
    setNotifiche: setNotifiche
  }

  const utenteSelezionatoContext = {
    utenteSelezionato: utenteSelezionato,
    setUtenteSelezionato: setUtenteSelezionato
  }

  const allTransazioniContext = {
    allTransazioni: allTransazioni,
    setAllTransazioni: setAllTransazioni
  }

  const allContiContext = {
    allConti: allConti,
    setAllConti: setAllConti
  }

  return (
    <div className='row'>
      <UtenteContext.Provider value={utenteContext}>
        <AnagraficaContext.Provider value={anagraficaContext}>
          <ConnessoContext.Provider value={connessoContext}>
            <ContoCorrenteContext.Provider value={contoCorrenteContext}>
              <MovimentoContext.Provider value={movimentoContext}>
                <OtpContext.Provider value={otpContext}>
                  <NotificheContext.Provider value={notificheContext}>
                    <UtenteSelezionatoContext.Provider value={utenteSelezionatoContext}>
                      <AllTransazioniContext.Provider value={allTransazioniContext}>
                        <AllContiContext.Provider value={allContiContext}>
                          <div className='col-12'>
                            <Header />
                          </div>
                          <div className='col-12'>
                            <SideBar />
                            <NavBar />
                          </div>
                          <div className='col-12'>
                            <Main />
                          </div>
                          <div className='col-12' style={{ marginTop: 180 }}>
                            <Footer />
                          </div>
                        </AllContiContext.Provider>
                      </AllTransazioniContext.Provider>
                    </UtenteSelezionatoContext.Provider>
                  </NotificheContext.Provider>
                </OtpContext.Provider>
              </MovimentoContext.Provider>
            </ContoCorrenteContext.Provider>
          </ConnessoContext.Provider>
        </AnagraficaContext.Provider>
      </UtenteContext.Provider>
    </div>
  )
}

export default App;
