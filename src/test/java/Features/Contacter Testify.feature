Feature: US 11 Contacter Testify
  En tant que visiteur
  Je souhaite contacter Testify
  Afin de se renseigner sur...

Scenario: TC_001 - Tester les champs requis
    Given un visiteur sur le formulaire de contact
    When je fais le captcha
    #soit faire manuellement
    #soit avec 2Captcha
    And je clique sur le bouton submit
    Then je dois avoir le message d erreur suivant "There are errors on the form. Please fix them before continuing."

Scenario: TC_002 - Remplir le formulaire de contact avec des informations valides
		Given un visiteur sur le formulaire de contact
    When je saisie "nadhir" comme prénom, "bouhaouala" comme nom
    And je saisie "eshop" comme entreprise
    And je saisie "13 traversee galilee" comme adresse
    And je saisie "nadhir_bouhaouala@live.fr" comme email
    And je saisie "+33" et "0666666666" comme numéro de téléphone
    And je saisie "2" pour indiquer que l entreprise travaille dans le secteur des fruits secs
    And je saisie "ttttttttttttteeeexxxxttt" comme texte de contact
    And je coche que j accepte les conditions
    And je fais le captcha #on peut créer une boucle while dans le cas ou la detection du text est incorrecte, on peut utiliser setCaptcha2()
    And je clique sur le bouton submit
    Then je dois avoir le message suivant "Your submission has been received."

Scenario: TC_003 - Remplir le formulaire de contact avec des informations invalides
		Given un visiteur sur le formulaire de contact
		When je saisie "' --" comme prénom, "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" comme nom
    And je saisie "Null" comme entreprise
    And je saisie "Nan" comme adresse
    And je saisie "nadhir_bouhaouala" comme email
    And je saisie "xxxxx" et "xxxxxxxxxx" comme numéro de téléphone
    And je saisie "2" pour indiquer que l entreprise travaille dans le secteur des fruits secs
    And je saisie "null" comme texte de contact
    And je coche que j accepte les conditions
    And je fais le captcha
    And je clique sur le bouton submit
    Then je dois avoir le message d erreur suivant "There are errors on the form. Please fix them before continuing."

Scenario: TC_004 - Remplir le formulaire de contact avec des informations invalides du champ email (expression réguliaire)
		Given un visiteur sur le formulaire de contact
    When je saisie "nadhir" comme prénom, "bouhaouala" comme nom
    And je saisie "eshop" comme entreprise
    And je saisie "13 traversee galilee" comme adresse
    And je saisie "nadhir_bouhaouala" comme email
    And je saisie "+33" et "0666666666" comme numéro de téléphone
    And je saisie "2" pour indiquer que l entreprise travaille dans le secteur des fruits secs
    And je saisie "ttttttttttttteeeexxxxttt" comme texte de contact
    And je coche que j accepte les conditions
    And je fais le captcha #on peut créer une boucle while dans le cas ou la detection du text est incorrecte, on peut utiliser setCaptcha2()
    And je clique sur le bouton submit
    Then je dois avoir le message d erreur suivant "There are errors on the form. Please fix them before continuing."    

Scenario: TC_005 - Remplir le formulaire de contact avec des informations invalides du champ tel (number)
		Given un visiteur sur le formulaire de contact
    When je saisie "nadhir" comme prénom, "bouhaouala" comme nom
    And je saisie "eshop" comme entreprise
    And je saisie "13 traversee galilee" comme adresse
    And je saisie "nadhir_bouhaouala@live.fr" comme email
    And je saisie "xxx" et "xxxxxxxxx" comme numéro de téléphone
    And je saisie "2" pour indiquer que l entreprise travaille dans le secteur des fruits secs
    And je saisie "ttttttttttttteeeexxxxttt" comme texte de contact
    And je coche que j accepte les conditions
    And je fais le captcha #on peut créer une boucle while dans le cas ou la detection du text est incorrecte, on peut utiliser setCaptcha2()
    And je clique sur le bouton submit
    Then je dois avoir le message d erreur suivant "There are errors on the form. Please fix them before continuing."    

Scenario: TC_006 - Remplir le formulaire de contact avec des informations valides sans accepter les conditions
		Given un visiteur sur le formulaire de contact
    When je saisie "nadhir" comme prénom, "bouhaouala" comme nom
    And je saisie "eshop" comme entreprise
    And je saisie "13 traversee galilee" comme adresse
    And je saisie "nadhir_bouhaouala@live.fr" comme email
    And je saisie "0033" et "0606060606" comme numéro de téléphone
    And je saisie "2" pour indiquer que l entreprise travaille dans le secteur des fruits secs
    And je saisie "ttttttttttttteeeexxxxttt" comme texte de contact
    And je fais le captcha #on peut créer une boucle while dans le cas ou la detection du text est incorrecte, on peut utiliser setCaptcha2()
    And je clique sur le bouton submit
    Then je dois avoir le message d erreur suivant "There are errors on the form. Please fix them before continuing."    

    