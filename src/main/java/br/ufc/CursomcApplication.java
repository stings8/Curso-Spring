package br.ufc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.ufc.domain.Categoria;
import br.ufc.domain.Cidade;
import br.ufc.domain.Cliente;
import br.ufc.domain.Endereco;
import br.ufc.domain.Estado;
import br.ufc.domain.Pagamento;
import br.ufc.domain.PagamentoComBoleto;
import br.ufc.domain.PagamentoComCartao;
import br.ufc.domain.Pedido;
import br.ufc.domain.Produto;
import br.ufc.domain.enums.EstadoPagamento;
import br.ufc.domain.enums.TipoCliente;
import br.ufc.repositories.CategoriaRepository;
import br.ufc.repositories.CidadeRepository;
import br.ufc.repositories.ClienteRepository;
import br.ufc.repositories.EnderecoRepository;
import br.ufc.repositories.EstadoRepository;
import br.ufc.repositories.PagamentoRepository;
import br.ufc.repositories.PedidoRepository;
import br.ufc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	@Autowired
	CategoriaRepository categoriarepository;
	@Autowired
	ProdutoRepository produtorepository;
	@Autowired
	EstadoRepository estadorepository;
	@Autowired
	CidadeRepository cidaderepository;
	@Autowired
	ClienteRepository clienterepository;
	@Autowired
	EnderecoRepository enderecorepository;
	
	@Autowired
	PagamentoRepository pagamentorepository;
	
	@Autowired
	PedidoRepository pedidorepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "informatica");
		Categoria cat2 = new Categoria(null, "escritorio");
		
		Produto p1 = new Produto(null, "computador", 2000.00);
		Produto p2 = new Produto(null, "impressora", 800.00);
		Produto p3 = new Produto(null, "mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		

		
		categoriarepository.saveAll(Arrays.asList(cat1, cat2));
		produtorepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "minas gerais");
		Estado est2 = new Estado(null, "sao paulo");
		
		Cidade c1 = new Cidade(null, "uberlandia", est1);
		Cidade c2 = new Cidade(null, "sao paulo", est2);
		Cidade c3 = new Cidade(null, "campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		
		estadorepository.saveAll(Arrays.asList(est1, est2));
		cidaderepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "mariga@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		
		Endereco e1 = new Endereco(null, "Rua flores", "300", "apt 303", "jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "avenida matos", "105", "sala 000", "centro", "387777012", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienterepository.saveAll(Arrays.asList(cli1));
		enderecorepository.saveAll(Arrays.asList(e1, e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm" );
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pagamentorepository.saveAll(Arrays.asList(pagto1, pagto2));
		pedidorepository.saveAll(Arrays.asList(ped1, ped2));
		
	}
}
