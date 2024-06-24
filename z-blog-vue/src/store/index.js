import Vue from 'vue'
import Vuex from 'vuex'
import createPersistedState from 'vuex-persistedstate'
Vue.use(Vuex)

const store = new Vuex.Store({

  state:{
    isLoggedIn:"",
    blogContent:"",
    username:"",
  },
  mutations:{
    setIsLoading(state, data){
      state.isLoggedIn = data
    },
    setBlogContent(state, data){
      state.blogContent = data
    },
    setUsername(state, data){
      state.username = data
    },
  },
  actions: {

  },
  plugins: [createPersistedState({
    // storage: window.sessionStorage,
  })]
})

export default store;
