package aplicacao;

import java.util.ArrayList;
import java.util.Scanner;

public class Console {

    private final ArrayList<Cliente> clientes = new ArrayList<>();
    private final ArrayList<Colaborador> colaboradores = new ArrayList<>();
    private final ArrayList<Servico> servicos = new ArrayList<>();
    private final ArrayList<Contrato> contratos = new ArrayList<>();
    private final ArrayList<Fatura> faturas = new ArrayList<>();
    private final ArrayList<ChamadoSuporte> chamados = new ArrayList<>();

    public Cliente consultarCliente(int codigo) {
        for (Cliente c : clientes) {
            if (c.getCodigo() == codigo) {
                return c;
            }
        }
        return null;
    }

    public Colaborador consultarColaborador(int codigo) {
        for (Colaborador col : colaboradores) {
            if (col.getCodigo() == codigo) {
                return col;
            }
        }
        return null;
    }

    public Servico consultarServico(int codigo) {
        for (Servico s : servicos) {
            if (s.getCodigo() == codigo) {
                return s;
            }
        }
        return null;
    }

    public Contrato consultarContrato(int codigo) {
        for (Contrato c : contratos) {
            if (c.getCodigo() == codigo) {
                return c;
            }
        }
        return null;
    }

    public Fatura consultarFatura(int codigo) {
        for (Fatura f : faturas) {
            if (f.getCodigo() == codigo) {
                return f;
            }
        }
        return null;
    }

    public ChamadoSuporte consultarChamado(int codigo) {
        for (ChamadoSuporte ch : chamados) {
            if (ch.getCodigo() == codigo) {
                return ch;
            }
        }
        return null;
    }

    public void executar() {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;
        servicos.add(new Servico(101, "Cloud Server Pro", "Servidor Dedicated vCPU", 450.00));
        servicos.add(new Servico(102, "Backup Nuvem 1TB", "Backup Automatizado Diário", 150.00));
        do {
            System.out.println("\n--- MENU ONEX DATA CENTER ---");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Consultar cliente");
            System.out.println("3 - Listar clientes");
            System.out.println("4 - Atualizar cliente");
            System.out.println("5 - Remover cliente");
            System.out.println("---------------------------------");
            System.out.println("6 - Cadastrar colaborador");
            System.out.println("7 - Consultar colaborador");
            System.out.println("8 - Listar colaboradores");
            System.out.println("9 - Atualizar colaborador");
            System.out.println("10 - Remover colaborador");
            System.out.println("---------------------------------");
            System.out.println("11 - Cadastrar serviço");
            System.out.println("12 - Listar serviços");
            System.out.println("13 - Registrar contrato");
            System.out.println("14 - Listar contratos");
            System.out.println("15 - Gerar fatura");
            System.out.println("16 - Registrar pagamento de fatura");
            System.out.println("17 - Listar faturas");
            System.out.println("18 - Abrir chamado de suporte");
            System.out.println("19 - Atribuir técnico a chamado");
            System.out.println("20 - Listar chamados");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao) {
                    case 1:
                        System.out.print("Digite o código do cliente: ");
                        int codCli = Integer.parseInt(scanner.nextLine());
                        if (consultarCliente(codCli) != null) {
                            System.out.println("Código de cliente já existente.");
                            break;
                        }
                        System.out.print("Digite o nome: ");
                        String nomeCli = scanner.nextLine();
                        System.out.print("Digite o e-mail: ");
                        String emailCli = scanner.nextLine();
                        System.out.print("Digite o telefone: ");
                        String telCli = scanner.nextLine();
                        System.out.print("Digite o CPF/CNPJ: ");
                        String docCli = scanner.nextLine();
                        System.out.print("Digite a razão social: ");
                        String rsCli = scanner.nextLine();
                        System.out.print("Digite o endereço: ");
                        String endCli = scanner.nextLine();
                        Cliente novoCliente = new Cliente(codCli, nomeCli, emailCli, telCli, docCli, rsCli, endCli);
                        clientes.add(novoCliente);
                        System.out.println("Cliente cadastrado.");
                        break;
                    case 2:
                        System.out.print("Digite o código do cliente: ");
                        int codConsCli = Integer.parseInt(scanner.nextLine());
                        Cliente cliConsultado = consultarCliente(codConsCli);
                        if (cliConsultado != null) {
                            System.out.println(cliConsultado);
                        } else {
                            System.out.println("Registro não encontrado.");
                        }
                        break;
                    case 3:
                        if (clientes.isEmpty()) {
                            System.out.println("Nenhum cliente cadastrado.");
                        } else {
                            for (Cliente c : clientes) {
                                System.out.println(c);
                            }
                        }
                        break;
                    case 4:
                        System.out.print("Digite o código do cliente que deseja atualizar: ");
                        int codAtuCli = Integer.parseInt(scanner.nextLine());
                        Cliente cliParaAtualizar = consultarCliente(codAtuCli);
                        if (cliParaAtualizar != null) {
                            System.out.print("Digite o novo nome: ");
                            String nNome = scanner.nextLine();
                            System.out.print("Digite o novo e-mail: ");
                            String nEmail = scanner.nextLine();
                            System.out.print("Digite o novo telefone: ");
                            String nTel = scanner.nextLine();
                            System.out.print("Digite o novo CPF/CNPJ: ");
                            String nDoc = scanner.nextLine();
                            System.out.print("Digite a nova razão social: ");
                            String nRS = scanner.nextLine();
                            System.out.print("Digite o novo endereço: ");
                            String nEnd = scanner.nextLine();
                            cliParaAtualizar.atualizarDados(nNome, nEmail, nTel, nDoc, nRS, nEnd);
                            System.out.println("Dados do cliente atualizados.");
                        } else {
                            System.out.println("Registro não encontrado.");
                        }
                        break;
                    case 5:
                        System.out.print("Digite o código do cliente para remover: ");
                        int codRemCli = Integer.parseInt(scanner.nextLine());
                        Cliente cliParaRemover = consultarCliente(codRemCli);
                        if (cliParaRemover != null) {
                            boolean temContratoAtivo = false;
                            for (Contrato contr : contratos) {
                                if (contr.getCliente().getCodigo() == codRemCli
                                        && contr.isAtivo()) {
                                    temContratoAtivo = true;
                                    break;
                                }
                            }
                            if (!temContratoAtivo) {
                                clientes.remove(cliParaRemover);
                                System.out.println("Cliente removido.");
                            } else {
                                System.out.println("Cliente não removido. Há contrato ativo vinculado.");
                            }
                        } else {
                            System.out.println("Registro não encontrado.");
                        }
                        break;
                    case 6:
                        System.out.print("Digite o código do colaborador: ");
                        int codCol = Integer.parseInt(scanner.nextLine());
                        if (consultarColaborador(codCol) != null) {
                            System.out.println("Código de colaborador já existente.");
                            break;
                        }
                        System.out.print("Digite o nome: ");
                        String nomeCol = scanner.nextLine();
                        System.out.print("Digite o e-mail: ");
                        String emailCol = scanner.nextLine();
                        System.out.print("Digite o telefone: ");
                        String telCol = scanner.nextLine();
                        System.out.print("Digite o cargo: ");
                        String cargoCol = scanner.nextLine();
                        System.out.print("Digite o departamento: ");
                        String deptoCol = scanner.nextLine();
                        System.out.print("Digite o nível de acesso (1:Comum, 2:Admin, 3:Super): ");
                        int nivelCol = Integer.parseInt(scanner.nextLine());
                        Colaborador novoColaborador = new Colaborador(codCol, nomeCol, emailCol, telCol, cargoCol, deptoCol, nivelCol);
                        colaboradores.add(novoColaborador);
                        System.out.println("Colaborador cadastrado.");
                        break;
                    case 7:
                        System.out.print("Digite o código do colaborador: ");
                        int codConsCol = Integer.parseInt(scanner.nextLine());
                        Colaborador colConsultado = consultarColaborador(codConsCol);
                        if (colConsultado != null) {
                            System.out.println(colConsultado);
                        } else {
                            System.out.println("Registro não encontrado.");
                        }
                        break;
                    case 8:
                        if (colaboradores.isEmpty()) {
                            System.out.println("Nenhum colaborador cadastrado.");
                        } else {
                            for (Colaborador col : colaboradores) {
                                System.out.println(col);
                            }
                        }
                        break;
                    case 9:
                        System.out.print("Digite o código do colaborador que deseja atualizar: ");
                        int codAtuCol = Integer.parseInt(scanner.nextLine());
                        Colaborador colParaAtualizar = consultarColaborador(codAtuCol);
                        if (colParaAtualizar != null) {
                            System.out.print("Digite o novo nome: ");
                            String nNomeCol = scanner.nextLine();
                            System.out.print("Digite o novo e-mail: ");
                            String nEmailCol = scanner.nextLine();
                            System.out.print("Digite o novo telefone: ");
                            String nTelCol = scanner.nextLine();
                            System.out.print("Digite o novo cargo: ");
                            String nCargo = scanner.nextLine();
                            System.out.print("Digite o novo departamento: ");
                            String nDepto = scanner.nextLine();
                            System.out.print("Digite o novo nível de acesso (0 para manter): ");
                            int nNivel = Integer.parseInt(scanner.nextLine());
                            colParaAtualizar.atualizarDados(nNomeCol, nEmailCol, nTelCol, nCargo, nDepto, nNivel);
                            System.out.println("Dados do colaborador atualizados.");
                        } else {
                            System.out.println("Registro não encontrado.");
                        }
                        break;
                    case 10:
                        System.out.print("Digite o código do colaborador para remover: ");
                        int codRemCol = Integer.parseInt(scanner.nextLine());
                        Colaborador colParaRemover = consultarColaborador(codRemCol);
                        if (colParaRemover != null) {
                            colaboradores.remove(colParaRemover);
                            System.out.println("Colaborador removido.");
                        } else {
                            System.out.println("Registro não encontrado.");
                        }
                        break;
                    case 11:
                        System.out.print("Digite o código do serviço: ");
                        int codServ = Integer.parseInt(scanner.nextLine());
                        System.out.print("Digite o nome: ");
                        String nomeServ = scanner.nextLine();
                        System.out.print("Digite a descrição: ");
                        String descServ = scanner.nextLine();
                        System.out.print("Digite o valor mensal (R$): ");
                        double valServ = Double.parseDouble(scanner.nextLine());
                        servicos.add(new Servico(codServ, nomeServ, descServ, valServ));
                        System.out.println("Serviço cadastrado.");
                        break;
                    case 12:
                        if (servicos.isEmpty()) {
                            System.out.println("Nenhum serviço cadastrado.");
                        } else {
                            for (Servico s : servicos) {
                                System.out.println(s);
                            }
                        }
                        break;
                    case 13:
                        System.out.print("Digite o código do contrato: ");
                        int codContr = Integer.parseInt(scanner.nextLine());
                        System.out.print("Digite o código do cliente: ");
                        int codCliContr = Integer.parseInt(scanner.nextLine());
                        Cliente cliContr = consultarCliente(codCliContr);
                        if (cliContr == null) {
                            System.out.println("Registro não encontrado.");
                            break;
                        }
                        Contrato novoContrato = new Contrato(codContr, cliContr);
                        int codServChoice = -1;
                        while (codServChoice != 0) {
                            System.out.print("Digite o código do serviço (ou 0 para encerrar): ");
                            codServChoice = Integer.parseInt(scanner.nextLine());
                            if (codServChoice != 0) {
                                Servico sFound = consultarServico(codServChoice);
                                if (sFound == null) {
                                    System.out.println("Registro não encontrado.");
                                } else if (!sFound.isAtivo()) {
                                    System.out.println("Serviço indisponível.");
                                } else if (novoContrato.getServicos().contains(sFound)) {
                                    System.out.println("Serviço já selecionado neste contrato.");
                                } else {
                                    novoContrato.adicionarServico(sFound);
                                    System.out.println("Serviço adicionado.");
                                }
                            }
                        }
                        contratos.add(novoContrato);
                        System.out.println("Contrato registrado.");
                        break;
                    case 14:
                        if (contratos.isEmpty()) {
                            System.out.println("Nenhum contrato registrado.");
                        } else {
                            for (Contrato c : contratos) {
                                System.out.println(c);
                            }
                        }
                        break;
                    case 15:
                        System.out.print("Digite o código da fatura: ");
                        int codFat = Integer.parseInt(scanner.nextLine());
                        System.out.print("Digite o código do contrato: ");
                        int codContrFat = Integer.parseInt(scanner.nextLine());
                        Contrato contrFat = consultarContrato(codContrFat);
                        if (contrFat == null) {
                            System.out.println("Registro não encontrado.");
                            break;
                        }
                        faturas.add(new Fatura(codFat, contrFat));
                        System.out.println("Fatura gerada.");
                        break;
                    case 16:
                        System.out.print("Digite o código da fatura para pagamento: ");
                        int codFatPag = Integer.parseInt(scanner.nextLine());
                        Fatura fatPag = consultarFatura(codFatPag);
                        if (fatPag != null) {
                            System.out.print("Digite o valor pago (R$): ");
                            double valPag = Double.parseDouble(scanner.nextLine());
                            if (fatPag.registrarPagamento(valPag)) {
                                System.out.println("Pagamento registrado.");
                            } else {
                                System.out.println("Não foi possível registrar o pagamento.");
                            }
                        } else {
                            System.out.println("Registro não encontrado.");
                        }
                        break;
                    case 17:
                        if (faturas.isEmpty()) {
                            System.out.println("Nenhuma fatura registrada.");
                        } else {
                            for (Fatura f : faturas) {
                                System.out.println(f);
                            }
                        }
                        break;
                    case 18:
                        System.out.print("Digite o código do chamado: ");
                        int codCham = Integer.parseInt(scanner.nextLine());
                        System.out.print("Digite o código do cliente: ");
                        int codCliCham = Integer.parseInt(scanner.nextLine());
                        Cliente cliCham = consultarCliente(codCliCham);
                        if (cliCham == null) {
                            System.out.println("Registro não encontrado.");
                            break;
                        }
                        System.out.print("Digite o assunto: ");
                        String assCham = scanner.nextLine();
                        System.out.print("Digite a prioridade (Baixa/Média/Alta): ");
                        String prioCham = scanner.nextLine();
                        chamados.add(new ChamadoSuporte(codCham, cliCham, assCham, prioCham));
                        System.out.println("Chamado de suporte aberto.");
                        break;
                    case 19:
                        System.out.print("Digite o código do chamado: ");
                        int codChamAtrib = Integer.parseInt(scanner.nextLine());
                        ChamadoSuporte chamAtrib = consultarChamado(codChamAtrib);
                        if (chamAtrib == null) {
                            System.out.println("Registro não encontrado.");
                            break;
                        }
                        System.out.print("Digite o código do colaborador (técnico): ");
                        int codTecAtrib = Integer.parseInt(scanner.nextLine());
                        Colaborador tecAtrib = consultarColaborador(codTecAtrib);
                        if (tecAtrib == null) {
                            System.out.println("Registro não encontrado.");
                            break;
                        }
                        chamAtrib.atribuirTecnico(tecAtrib);
                        System.out.println("Técnico atribuído ao chamado.");
                        break;
                    case 20:
                        if (chamados.isEmpty()) {
                            System.out.println("Nenhum chamado registrado.");
                        } else {
                            for (ChamadoSuporte ch : chamados) {
                                System.out.println(ch);
                            }
                        }
                        break;
                    case 0:
                        System.out.println("Aplicação encerrada.");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro.");
            }
        } while (opcao != 0);
        scanner.close();
    }
}
